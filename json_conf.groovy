import groovy.json.*
import static groovy.json.JsonParserType.*

def parser = new JsonSlurper().setType(LAX)

def conf = parser.parseText '''
   // conf
   {
      # pound
      environment: 'production',
      'server': 5
   }
'''

//def conf = [ environment: 'production', server: 5 ]
assert conf.environment == 'production'
assert conf.server == 5

