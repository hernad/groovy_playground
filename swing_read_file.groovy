import groovy.swing.SwingBuilder
import javax.swing.JFrame
import javax.swing.JFileChooser

public class RevisedGroovyFileViewer {
 
 static void main(String[] args) {
      def viewer = new RevisedGroovyFileViewer() 
 }
 
 private SwingBuilder swing

 public RevisedGroovyFileViewer() {

   swing = new SwingBuilder()
   swing.edt {
      fileChooser = fileChooser()
      frame( title: "FileViewer",
          defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
          pack: true, visible: true, id: "frame" ) {
             borderLayout()
             button("<Odaberi fajl>", constraints: context.NORTH,
             actionPerformed: this.&selectFile)
             scrollPane( constraints: context.CENTER ) {
                 textArea( id: "textArea", editable: false, lineWrap: true )
             }
         }
      frame.size = [ 1024, 768 ]
   }
 }
 
 private void selectFile( event = null ) {
   int answer = swing.fileChooser.showOpenDialog(swing.frame)
   if( answer == JFileChooser.APPROVE_OPTION ) {
     readFile(swing.fileChooser.selectedFile)
   }
 }
 
 private void readFile( File file ) {
 
    swing.doOutside {
     String text = file.text
     doLater { 
      textArea.text = text
      textArea.caretPosition = 0
     }
   }
   
 }

}
