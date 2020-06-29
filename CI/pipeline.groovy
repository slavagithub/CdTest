import groovy.json.JsonSlurper
import jenkins.model.*

static void doit(String[] args) {
//    Example.sum(5, 8)
//     sum(5, 7)
    def jsonSlurper = new JsonSlurper()
    def object = jsonSlurper.parseText('{ "name": "John Doe", "sdk":["marvel", "lamer"] }')
    object.sdk.add("another")
    object.put("AnotherPackage",Eval.me("['one','two']"))
    println object;

}

static void doJob(){


def jobName = "./CI/my-new-job"
def configXml = new File('myjob.xml').text 

def xmlStream = new ByteArrayInputStream( configXml.getBytes() )

Jenkins.instance.createProjectFromXML(jobName, xmlStream)
}

pipeline {
    agent any;
  parameters {
    string( name: 'BuildConfiguration', 
            defaultValue: 'Release', 
            description: 'Configuration to build (Debug/Release/...)')
    string( name: 'BuildConfiguration1', 
            defaultValue: 'Release1', 
            description: 'Configuration to build (Debug/Release/...)')
  }
  
  stages {
        stage('Build') { 
            steps {
                echo "Building configuration: " + params.BuildConfiguration
            }
        }
        stage('Test'){
            steps{
                doit();
            }
        }
		 stage('Git'){
            steps{
            bat("dir")
            }
        }
		
		stage('New job'){
		steps{
		doJob()

		}
		}
  }
  
  
}
  echo "Building configuration: " + params.BuildConfiguration