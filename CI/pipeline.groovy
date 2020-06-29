import groovy.json.JsonSlurper

static void doit(String[] args) {
//    Example.sum(5, 8)
//     sum(5, 7)
    def jsonSlurper = new JsonSlurper()
    def object = jsonSlurper.parseText('{ "name": "John Doe", "sdk":["marvel", "lamer"] }')
    object.sdk.add("another")
    object.put("AnotherPackage",Eval.me("['one','two']"))
    println object;

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
  }
  
  
}
  echo "Building configuration: " + params.BuildConfiguration