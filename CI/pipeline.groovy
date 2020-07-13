import groovy.json.JsonSlurper
import jenkins.model.*
import java.util.Map
import jenkins.*
import hudson.*
import hudson.model.*   
import jenkins.model.Jenkins
import com.cloudbees.hudson.plugins.folder.*


static String addJob(String folderName, String subFolderName, String name, String xmlFile){
    def jenkins = Jenkins.instance
    def item = jenkins.getItemByFullName("JF")
    def workspacePath = jenkins.getWorkspaceFor (item)

    def file = new File(workspacePath.toString()+xmlFile)
    def xmlStream = new ByteArrayInputStream( file.getBytes() )

    def folder = jenkins.getItem(folderName)
    def subFolder = folder.getItem(subFolderName)

    subFolder.createProjectFromXML(name, xmlStream)
    return "DONE"
}



pipeline {
    agent any;
  parameters {
    string( name: 'LobName',
            defaultValue: 'lob',
            description: 'New LOB name')
      string( name: 'email',
            defaultValue: 'email',
            description: 'email to notify' +
                    '')
  }

  stages {

        stage('Adding Jobs'){
            steps{
               echo addJob("Routing",  "DEV2Deploy",  "DDDnew-job","\\myjob.xml")
            }
        }


  }
  
  
}
  echo "Building configuration: " + params.BuildConfiguration




