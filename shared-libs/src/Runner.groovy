@Grab(group='com.squareup.okhttp3', module='okhttp', version='4.4.1')


public static void main(String[] args) {

    ConfigFilesManager.addRulesPackages("OmniExpress2",     "oe2.555,oe2.oAAAAAAAAAAices.888.hoop.rt")

    println "hello"

    def UpdateDetails details = new UpdateDetails()
    details.lob = "NEW_GOOD"
    details.rulesPackages = ["adsf.sdf.s","sdf2.sdf.sdf2"]
    details.email = "AGOOD_DL"
    details.copyServersFromLob = "UHCCS"

    IConfigProcessor grs = new JsonIConfig_Routing_GRS()
//    grs.setContent(new File('C:\\Slava\\repositories\\getter\\data\\JsonConfig_Routing_GRS.json').text)

    def configProcessors = [grs]

//    new RoutingProcessor()]//[new RoutingRulesListProcessor(), new AnotherProcessor()]

//    for(nextProcessor in configProcessors){
//        nextProcessor.setUpdateDetails(details)
//        nextProcessor.setContent(Getter.getConfig().toString())
//        nextProcessor.updateContent()
//        def updatedContent = nextProcessor.getUpdated()
//        def content = new JsonBuilder(updatedContent).toPrettyString()
//        def prettifiedContent = content.replaceAll("\n","\\\\n")
//        prettifiedContent = prettifiedContent.replaceAll("\"", '\\\\"')
//        Getter.saveConfig(prettifiedContent)
//        println updatedContent
//    }



//  \n
//   def content = """{"AA1"
//:BBD}"""
//////    println " {\"config\": {\"stapler-class\": \"org.jenkinsci.plugins.configfiles.json.JsonConfig\", \"id\": \"e87b8ccb-d30e-4b2c-9018-2d759c4383a7\", \"providerId\": \"org.jenkinsci.plugins.configfiles.json.JsonConfig\", \"name\": \"JsonConfig\", \"comment\": \"\", \"content\":${content}, \"Jenkins-Crumb\": \"117486bb7d8e2a49d688968be1d85d682267bbdc73470d646201321f53dfddb7\"}"
//    def prettifiedContent = content.replaceAll("\n","\\\\n")
//    prettifiedContent = prettifiedContent.replaceAll("\"", '\\\\"')
//    Getter.saveConfig(prettifiedContent)

//    Getter.saveConfig(""" {[RULE_APP_LISTS:[AARPHealth_AppName:[AARPHealth], AOF_AppName:[AOF], COVID19_AppName:[WIN]}""")
}


