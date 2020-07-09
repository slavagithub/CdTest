import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

class JsonIConfig_Routing_RulesList implements IConfigProcessor {

    static String fileId = "333"
    static String fileName = "JsonConfig_Routing"
    static String fileComment = "Routing ORS SCXML Job Configuration file - Routing Team"
    static String RP_LIST = "RULES_PACKAGE_LIST"
    static String RP_LIST_HF = "RULES_PACKAGE_LIST_HF"
    static String ALL_PCKG_LIST = "ALL_PACKAGE_LIST"
    UpdateDetails config
    Boolean isUpdated = false

    def parsedJson

    void addLobIfAbsent(String lob) {
        if (!(lob.concat("_Rules_PackageName") in parsedJson[RP_LIST])) {
            parsedJson[RP_LIST].put(lob + "_Rules_PackageName", Eval.me("[]"))
        }
        if (!(lob.concat("_Rules_PackageName") in parsedJson[RP_LIST_HF])) {
            parsedJson[RP_LIST_HF].put(lob + "_Rules_PackageName", Eval.me("[]"))
        }
    }

    void addRulesPackage(String lob, String pckg) {
        if (!(pckg in parsedJson[RP_LIST][lob + "_Rules_PackageName"])) {
            parsedJson[RP_LIST][lob + "_Rules_PackageName"].add(pckg)
        }
        if (!(pckg.concat(".hotfix") in parsedJson[RP_LIST_HF][lob + "_Rules_PackageName"])) {
            parsedJson[RP_LIST_HF][lob + "_Rules_PackageName"].add(pckg + ".hotfix")
        }
    }

    void addAllPackagesList(String pckg) {
        if (!(pckg in parsedJson[ALL_PCKG_LIST]["Rules_PackageName"])) {
            parsedJson[ALL_PCKG_LIST]["Rules_PackageName"].add(pckg)
        }
    }




    @Override
    void setUpdateDetails(UpdateDetails inConfig) {
        config = inConfig
    }

    @Override
    void updateContent() {
        addLobIfAbsent(config.lob)
        for(nextRulesPackage in config.rulesPackages) {
            addRulesPackage(config.lob, nextRulesPackage)
            addAllPackagesList(nextRulesPackage)
        }
        isUpdated = true
    }

    @Override
    void setContent(Object confCont) {
        def jsonSlurper = new JsonSlurper()
        parsedJson = jsonSlurper.parseText(new JsonBuilder(config).toPrettyString())
    }

    @Override
    Object getUpdated() {
        if(isUpdated) {
            return parsedJson
        }
        println "Update of Routing Rules List config is not completed yet"
    }

    @Override
    String getFileId() {
        return fileId
    }

    @Override
    String getFileName() {
        return fileName
    }

    @Override
    String getFileComment() {
        return fileComment
    }
}
