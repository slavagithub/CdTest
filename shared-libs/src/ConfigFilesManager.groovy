import groovy.json.JsonBuilder

class ConfigFilesManager{
    static String addRulesPackages(String lob, String rulesPackages){

        def UpdateDetails details = new UpdateDetails()
        details.lob = lob
        details.rulesPackages = rulesPackages.split(",")


        ConfigProcessor nextProcessor = new JsonConfig_Routing_RulesList()

        nextProcessor.setUpdateDetails(details)
        nextProcessor.setContent(Getter.getConfig().toString())
        nextProcessor.updateContent()
        def updatedContent = nextProcessor.getUpdated()
        def content = new JsonBuilder(updatedContent).toPrettyString()
        def prettifiedContent = content.replaceAll("\n","\\\\n")
        prettifiedContent = prettifiedContent.replaceAll("\"", '\\\\"')
        Getter.saveConfig(prettifiedContent)

        return "Rules package(s) "+rulesPackages+" was(were) successfully added to "+lob


    }

}
