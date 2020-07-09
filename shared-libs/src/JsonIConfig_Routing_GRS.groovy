import groovy.json.JsonSlurper

class JsonIConfig_Routing_GRS implements IConfigProcessor {
    static String fileId = "333"
    static String fileName = "JsonConfig_Routing"
    static String fileComment = "Routing ORS SCXML Job Configuration file - Routing Team"

    static String RAPP_LIST = "RULE_APP_LISTS"
    static String EMAIL_SECTION = "RULES_EMAIL_CONFIG"
    static String DEV2_SECTION = "DEV2_RULES_CONFIG"
    static String QA_SECTION = "QA_RULES_CONFIG"
    static String STAGE_SECTION = "STAGE_RULES_CONFIG"
    static String PROD_SECTION = "PROD_RULES_CONFIG"

    UpdateDetails updateDetails
    Boolean isUpdated = false

    def content

    void addRulesAppList(String lob){
        if (lob.concat("_AppName") !in content[RAPP_LIST]) {
//            content[RAPP_LIST].put(lob + "_AppName", Eval.me("[${lob}]"))
            content[RAPP_LIST].put(lob + "_AppName", Eval.me("[\"${lob}\"]"))

        }
    }

    void addEmail(String lob, String email){
        if (lob.concat("_GRS_teamEmailDL") !in content[EMAIL_SECTION]) {
            content[EMAIL_SECTION].put(lob + "_GRS_teamEmailDL", Eval.me("[\"OMNI_DEV_LEADS_DL@ds.uhc.com;${email}@ds.uhc.com\"]"))
        }
    }

    void addDev2(String lob){
        if (lob.concat("_GRS_jenkinsImportJobName") !in content[DEV2_SECTION]) {
            content[DEV2_SECTION].put(lob + "_GRS_jenkinsImportJobName", Eval.me("[\"Routing Engineering/DEV2_RULE_DEPLOY/${lob}_DEV2_RULE_DEPLOY_SUB\"]"))
        }
        if (lob.concat("_GRS_importNodeName") !in content[DEV2_SECTION]) {
            content[DEV2_SECTION].put(lob + "_GRS_importNodeName", Eval.me("[\"EnterpriseRt\",\"${lob}\"]"))
        }
        if (lob.concat("_GRS_exportNodeLevel") !in content[DEV2_SECTION]) {
            content[DEV2_SECTION].put(lob + "_GRS_exportNodeLevel", Eval.me("[2]"))
        }
        if (lob.concat("_GRS_importNodeLevel") !in content[DEV2_SECTION]) {
            content[DEV2_SECTION].put(lob + "_GRS_importNodeLevel", Eval.me("[2]"))
        }

    }

    void addQA(String lob){
        if (lob.concat("_GRS_importNodeName") !in content[QA_SECTION]) {
            content[QA_SECTION].put(lob + "_GRS_importNodeName", Eval.me("[\"EnterpriseRt\",\"${lob}\"]"))
        }
        if (lob.concat("_GRS_exportNodeLevel") !in content[QA_SECTION]) {
            content[QA_SECTION].put(lob + "_GRS_exportNodeLevel", Eval.me("[2]"))
        }
        if (lob.concat("_GRS_importNodeLevel") !in content[QA_SECTION]) {
            content[QA_SECTION].put(lob + "_GRS_importNodeLevel", Eval.me("[2]"))
        }

    }

    void addStage(String lob){
        if (lob.concat("_GRS_importNodeName") !in content[STAGE_SECTION]) {
            content[STAGE_SECTION].put(lob + "_GRS_importNodeName", Eval.me("[\"EnterpriseRt\",\"${lob}\"]"))
        }
        if (lob.concat("_GRS_exportNodeLevel") !in content[STAGE_SECTION]) {
            content[STAGE_SECTION].put(lob + "_GRS_exportNodeLevel", Eval.me("[2]"))
        }
        if (lob.concat("_GRS_importNodeLevel") !in content[STAGE_SECTION]) {
            content[STAGE_SECTION].put(lob + "_GRS_importNodeLevel", Eval.me("[2]"))
        }

    }

    void addProd(String lob){
        if (lob.concat("_GRS_importNodeName") !in content[PROD_SECTION]) {
            content[PROD_SECTION].put(lob + "_GRS_importNodeName", Eval.me("[\"EnterpriseRt\",\"${lob}\"]"))
        }
        if (lob.concat("_GRS_exportNodeLevel") !in content[PROD_SECTION]) {
            content[PROD_SECTION].put(lob + "_GRS_exportNodeLevel", Eval.me("[2]"))
        }
        if (lob.concat("_GRS_importNodeLevel") !in content[PROD_SECTION]) {
            content[PROD_SECTION].put(lob + "_GRS_importNodeLevel", Eval.me("[2]"))
        }

    }

    @Override
    void setUpdateDetails(UpdateDetails config) {
        updateDetails = config
    }

    @Override
    void updateContent() {
        addRulesAppList(updateDetails.lob)
        addEmail(updateDetails.lob, updateDetails.email)
        addDev2(updateDetails.lob)
        addQA(updateDetails.lob)
        addStage(updateDetails.lob)
        addProd(updateDetails.lob)

        isUpdated = true
    }

    @Override
    void setContent(Object confCont) {
        def jsonSlurper = new JsonSlurper()
        content = jsonSlurper.parseText(confCont)
    }

    @Override
    Object getUpdated() {
        if(isUpdated) {
            return content
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

