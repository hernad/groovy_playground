def hashMap = [ field1: 'polje 1', field3: 'polje dva' ]

def count = hashMap.field1?.length()

if (count) {
   println "Count = ${count}" 
} else {
   println "count se nije moglo utvrditi"
}

def count2 = hashMap.field2?.length()

if (count2) {
   println "Count2 = ${count2}" 
} else {
   println "count2 se nije moglo utvrditi"
}
