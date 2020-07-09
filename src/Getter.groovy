
@Grab(group='com.squareup.okhttp3', module='okhttp', version='4.4.1')

@Grab('org.ccil.cowan.tagsoup:tagsoup:1.2.1')

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response



import org.ccil.cowan.tagsoup.Parser


public static void main(String[] args) {

    def html = ''' <!DOCTYPE html><html class=""><head resURL="/static/9c6fda29" data-rooturl="" data-resurl="/static/9c6fda29" data-imagesurl="/static/9c6fda29/images">
    
    

    <title>Jenkins</title><link rel="stylesheet" href="/static/9c6fda29/jsbundles/base-styles-v2.css" type="text/css"><link rel="stylesheet" href="/static/9c6fda29/css/color.css" type="text/css"><link rel="stylesheet" href="/static/9c6fda29/css/responsive-grid.css" type="text/css"><link rel="shortcut icon" href="/static/9c6fda29/favicon.ico" type="image/vnd.microsoft.icon"><link color="black" rel="mask-icon" href="/images/mask-icon.svg"><script>var isRunAsTest=false; var rootURL=""; var resURL="/static/9c6fda29";</script><script src="/static/9c6fda29/scripts/prototype.js" type="text/javascript"></script><script src="/static/9c6fda29/scripts/behavior.js" type="text/javascript"></script><script src='/adjuncts/9c6fda29/org/kohsuke/stapler/bind.js' type='text/javascript'></script><script src="/static/9c6fda29/scripts/yui/yahoo/yahoo-min.js"></script><script src="/static/9c6fda29/scripts/yui/dom/dom-min.js"></script><script src="/static/9c6fda29/scripts/yui/event/event-min.js"></script><script src="/static/9c6fda29/scripts/yui/animation/animation-min.js"></script><script src="/static/9c6fda29/scripts/yui/dragdrop/dragdrop-min.js"></script><script src="/static/9c6fda29/scripts/yui/container/container-min.js"></script><script src="/static/9c6fda29/scripts/yui/connection/connection-min.js"></script><script src="/static/9c6fda29/scripts/yui/datasource/datasource-min.js"></script><script src="/static/9c6fda29/scripts/yui/autocomplete/autocomplete-min.js"></script><script src="/static/9c6fda29/scripts/yui/menu/menu-min.js"></script><script src="/static/9c6fda29/scripts/yui/element/element-min.js"></script><script src="/static/9c6fda29/scripts/yui/button/button-min.js"></script><script src="/static/9c6fda29/scripts/yui/storage/storage-min.js"></script><script src="/static/9c6fda29/scripts/hudson-behavior.js" type="text/javascript"></script><script src="/static/9c6fda29/scripts/sortable.js" type="text/javascript"></script><script>crumb.init("Jenkins-Crumb", "4dc6528550e042bfe6d319355d5b38553c8094aefe18af80fb5ec882a1150315");</script><link rel="stylesheet" href="/static/9c6fda29/scripts/yui/container/assets/container.css" type="text/css"><link rel="stylesheet" href="/static/9c6fda29/scripts/yui/container/assets/skins/sam/container.css" type="text/css"><link rel="stylesheet" href="/static/9c6fda29/scripts/yui/menu/assets/skins/sam/menu.css" type="text/css"><link rel="stylesheet" href="/static/9c6fda29/jsbundles/ui-refresh-overrides.css" type="text/css"><link rel="search" href="/opensearch.xml" type="application/opensearchdescription+xml" title="Jenkins"><meta name="ROBOTS" content="INDEX,NOFOLLOW"><meta name="viewport" content="width=device-width, initial-scale=1"><style>.CodeMirror {border: 2px inset #dee;}</style><script src="/static/9c6fda29/jsbundles/vendors.js" type="text/javascript"></script><script src="/static/9c6fda29/jsbundles/page-init.js" type="text/javascript"></script></head><body data-model-type="org.jenkinsci.plugins.configfiles.ConfigFilesManagement" id="jenkins" class="yui-skin-sam two-column jenkins-2.235.1" data-version="2.235.1"><a href="#skip2content" class="skiplink">Skip to content</a><div id="page-head"><header id="header" class="page-header"><div class="page-header__brand"><div class="logo"><a id="jenkins-home-link" href="/"><img src="/static/9c6fda29/images/jenkins-header-logo-v2.svg" alt="[Jenkins]" id="jenkins-head-icon"><img src="/static/9c6fda29/images/title.png" alt="Jenkins" width="139" id="jenkins-name-icon" height="34"></a></div><a href="/" class="page-header__brand-link"><img src="/static/9c6fda29/images/jenkins-header-logo-v2.svg" alt="[Jenkins]" class="page-header__brand-image"><span class="page-header__brand-name">Jenkins</span></a></div><div class="searchbox hidden-xs"><form role="search" method="get" name="search" action="/search/" style="position:relative;" class="no-json"><div id="search-box-sizer"></div><div id="searchform"><input role="searchbox" name="q" placeholder="Пошук" id="search-box" class="main-search__input has-default-text"><span class="main-search__icon-leading"><svg viewBox="0 0 24 24" aria-hidden="" focusable="false" class="svg-icon "><use href="/static/9c6fda29/images/material-icons/svg-sprite-action-symbol.svg#ic_search_24px"></use></svg></span><a href="https://jenkins.io/redirect/search-box" class="main-search__icon-trailing"><svg viewBox="0 0 24 24" aria-hidden="" focusable="false" class="svg-icon "><use href="/static/9c6fda29/images/material-icons/svg-sprite-action-symbol.svg#ic_help_outline_24px"></use></svg></a><div id="search-box-completion"></div><script>createSearchBox("/search/");</script></div></form></div><div class="login page-header__hyperlinks"><div id="visible-am-insertion" class="page-header__am-wrapper"></div><a href="/user/slava" class="model-link inside inverse"><svg viewBox="0 0 24 24" aria-hidden="" focusable="false" class="svg-icon am-monitor-icon"><use href="/static/9c6fda29/images/material-icons/svg-sprite-social-symbol.svg#ic_person_24px"></use></svg><span class="hidden-xs hidden-sm">slava</span></a><a href="/logout"><svg viewBox="0 0 24 24" aria-hidden="" focusable="false" class="svg-icon "><use href="/static/9c6fda29/images/material-icons/svg-sprite-action-symbol.svg#ic_input_24px"></use></svg><span class="hidden-xs hidden-sm">Вийти</span></a></div></header><div id="breadcrumbBar"><tr id="top-nav"><td id="left-top-nav" colspan="2"><link rel='stylesheet' href='/adjuncts/9c6fda29/lib/layout/breadcrumbs.css' type='text/css' /><script src='/adjuncts/9c6fda29/lib/layout/breadcrumbs.js' type='text/javascript'></script><div class="top-sticker noedge"><div class="top-sticker-inner"><div class="breadcrumbs__wrapper"><ul id="breadcrumbs"><li class="item"><a href="/" class="model-link inside">Jenkins</a></li><li href="/" class="children"></li><li class="item"><a href="/configfiles/" class=" inside">Managed files</a></li><li class="separator"></li><style>.CodeMirror {border: 2px inset #dee;}</style></ul><div id="breadcrumb-menu-target"></div></div></div></div></td></tr></div></div><div id="page-body" class="clear"><div id="side-panel"><style>.CodeMirror {border: 2px inset #dee;}</style><div id="tasks"><div class="task"><a href="/manage" class="task-icon-link"><img src="/static/9c6fda29/images/24x24/setting.png" style="width: 24px; height: 24px; width: 24px; height: 24px; margin: 2px;" class="icon-setting icon-md"></a> <a href="/manage" title="Manage Jenkins" class="task-link">Manage Jenkins</a></div><div class="task"><a href="configfiles" class="task-icon-link"><img src="/static/9c6fda29/images/24x24/next.png" style="width: 24px; height: 24px; width: 24px; height: 24px; margin: 2px;" class="icon-next icon-md"></a> <a href="configfiles" title="Config Files" class="task-link">Config Files</a></div><div class="task"><a href="selectProvider" class="task-icon-link"><img src="/static/9c6fda29/images/24x24/new-package.png" style="width: 24px; height: 24px; width: 24px; height: 24px; margin: 2px;" class="icon-new-package icon-md"></a> <a href="selectProvider" title="Add a new Config" class="task-link">Add a new Config</a></div></div></div><div id="main-panel"><style>.CodeMirror {border: 2px inset #dee;}</style><a name="skip2content"></a><h1><img src="/static/9c6fda29/images/16x16/document_edit.gif" width="48" height="48"><img src="/static/9c6fda29/images/16x16/empty.gif" width="16" height="16">
\t\t\t\tEdit Configuration File
\t\t\t</h1><form method="post" autocomplete="off" action="saveConfig"><table width="100%"><link rel='stylesheet' href='/adjuncts/9c6fda29/lib/form/section_.css' type='text/css' /><script src='/adjuncts/9c6fda29/lib/form/section_.js' type='text/javascript'></script><tr name="config" style="display:none" class="row-set-start row-group-start"></tr><tr><td colspan="4"><div class="section-header">The configuration</div></td></tr><input name="stapler-class" type="hidden" value="org.jenkinsci.plugins.configfiles.json.JsonConfig"><tr><td class="setting-leftspace"> </td><td class="setting-name">ID</td><td class="setting-main">
   

  
  <input readonly="readonly" name="config.id" type="text" class="setting-input   " value="dcbf63a8-9f07-4c1d-9a05-03747b19c5aa"></td><td class="setting-no-help"></td></tr><tr class="validation-error-area"><td colspan="2"></td><td></td><td></td></tr><tr style="display:none"><td>
   

  
  <input readonly="readonly" name="config.providerId" type="text" class="setting-input   " value="org.jenkinsci.plugins.configfiles.json.JsonConfig"></td></tr><tr><td class="setting-leftspace"> </td><td class="setting-name">Name</td><td class="setting-main">
   

  
  <input name="config.name" type="text" class="setting-input   " value="JsonConfig"></td><td class="setting-no-help"></td></tr><tr class="validation-error-area"><td colspan="2"></td><td></td><td></td></tr><tr><td class="setting-leftspace"> </td><td class="setting-name">Comment</td><td class="setting-main">
   

  
  <input name="config.comment" type="text" class="setting-input   " value=""></td><td class="setting-no-help"></td></tr><tr class="validation-error-area"><td colspan="2"></td><td></td><td></td></tr><tr><td class="setting-leftspace"> </td><td class="setting-name">Content</td><td class="setting-main"><textarea name="config.content" id="config.content" rows="5" class="setting-input   ">{888:"simple",
 complex: cogmplex,
 hope: "hope",
 add:"add"}</textarea><div class="textarea-handle"></div></td><td class="setting-no-help"></td></tr><tr class="validation-error-area"><td colspan="2"></td><td></td><td></td></tr><tr><td colspan="4"><input name="Submit" type="submit" value="Submit" class="submit-button primary "></td></tr><tr class="row-set-end row-group-end"></tr></table></form></div></div><footer class="page-footer"><div class="container-fluid"><div class="page-footer__flex-row"><div class="page-footer__footer-id-placeholder" id="footer"></div><div class="page-footer__timestamp hidden-xs hidden-sm"><span class="page-footer__generated">
              Сторінка згенерована:
              <span class="page-footer__generated-timestamp">23 черв. 2020 11:33:00 EEST</span></span></div><div class="page-footer__links page-footer__links--white jenkins_ver"><a href="https://jenkins.io/" target="_blank">Jenkins 2.235.1</a></div></div></div></footer><script async="true" src="/static/9c6fda29/scripts/svgxuse.min.js" type="text/javascript"></script></body></html><link rel='stylesheet' href='/adjuncts/9c6fda29/org/kohsuke/stapler/codemirror/lib/codemirror.css' type='text/css' /><script src='/adjuncts/9c6fda29/org/kohsuke/stapler/codemirror/lib/codemirror.js' type='text/javascript'></script><script src='/adjuncts/9c6fda29/org/kohsuke/stapler/codemirror/mode/javascript/javascript.js' type='text/javascript'></script><link rel='stylesheet' href='/adjuncts/9c6fda29/org/kohsuke/stapler/codemirror/theme/default.css' type='text/css' /><script>var editor = CodeMirror.fromTextArea(document.getElementById("config.content"), {
\t        lineNumbers: true,
\t        matchBrackets: true,
\t        mode: "application/json"
\t      });</script>

Process finished with exit code 0
'''.stripMargin()

//    def content = new XmlSlurper( new Parser()).parseText( getConfig() )
//
////    List<String> spans = content.'**'.findAll { it.name() == 'SPAN' && it.@id?.text()?.startsWith( 'blk' ) }*.toString()
//
//    def res= content.depthFirst().findAll { it.@id == 'config.content' }[0]
//    println res
//    def toRep = "Replaced"
//    def sdf = "asdf${toRep}psdfsfd"
//    println sdf
////    println getConfig()
//    println(getCrumb())
//    saveConfig



}

static String getCrumb(){
    def username = "Slava"
    def password = "11e110cc052863bb70d5775e14888c2718"
    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    Request request = new Request.Builder()
            .url("http://localhost:8080/crumbIssuer/api/json")
            .method("GET", null)
            .addHeader("Cookie", "JSESSIONID.7ead4614=node01mqo9ixhg0n7v1u7xss4rebvc518.node0")
    .addHeader("Authorization",  "Basic ${"$username:$password".bytes.encodeBase64()}")
            .build();
    Response response = client.newCall(request).execute()

    return response;

}

public static Object getConfig(){
    def username = "Slava"
    def password = "11e110cc052863bb70d5775e14888c2718"
    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    Request request = new Request.Builder()
            .url("http://Slava:11e110cc052863bb70d5775e14888c2718@localhost:8080/configfiles/editConfig?id=e87b8ccb-d30e-4b2c-9018-2d759c4383a7")
            .method("GET", null)
            .addHeader("Cookie", "JSESSIONID.7ead4614=node0ivs9l1gztms51bd09m0rmrsia33.node0")
            .addHeader("Authorization",  "Basic ${"$username:$password".bytes.encodeBase64()}")
            .build();
    Response response = client.newCall(request).execute();
    def result =  response.body().string()

        def content = new XmlSlurper( new Parser()).parseText( result )

//    List<String> spans = content.'**'.findAll { it.name() == 'SPAN' && it.@id?.text()?.startsWith( 'blk' ) }*.toString()

    def res= content.depthFirst().findAll { it.@id == 'config.content' }[0]
//    println res
    return  res

}

public static void saveConfig(String content){
    def username = "Slava"
    def password = "11e110cc052863bb70d5775e14888c2718"

    def formedContent = "\"${content}\", \"\": \"\"}"

    def jsonVal = " {\"config\": {\"stapler-class\": \"org.jenkinsci.plugins.configfiles.json.JsonConfig\", \"id\": \"e87b8ccb-d30e-4b2c-9018-2d759c4383a7\", \"providerId\": \"org.jenkinsci.plugins.configfiles.json.JsonConfig\", \"name\": \"JsonConfig\", \"comment\": \"\", \"content\":${formedContent}, \"Jenkins-Crumb\": \"117486bb7d8e2a49d688968be1d85d682267bbdc73470d646201321f53dfddb7\"}"

    println jsonVal

    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("json", jsonVal)
            .build();
    Request request = new Request.Builder()
            .url("http://Slava:11e110cc052863bb70d5775e14888c2718@localhost:8080/configfiles/saveConfig")
            .method("POST", body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("Sec-Fetch-Dest", "document")
            .addHeader("Sec-Fetch-Site", "same-origin")
            .addHeader("Sec-Fetch-Mode", "navigate")
            .addHeader("Sec-Fetch-User", "?1")
            .addHeader("Cookie", "JSESSIONID.7ead4614=node015v5j7tudg8y41hs6e41g0v1wj42.node0")
            .addHeader("Authorization",  "Basic ${"$username:$password".bytes.encodeBase64()}")

            .build();
    Response response = client.newCall(request).execute();
//    println "RESULT IS"
//    println response.body().string()

}