@Grab(group='com.squareup.okhttp3', module='okhttp', version='4.4.1')

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response


class JobCreator{

    static String getNewJobXml(String dir, String subDir, String name, String lob, String email){

        String content = getJobXml(dir, subDir, name)
        return replaceFields(content, lob, email)

    }
    static replaceFields(String content, String lob, String email){

        def replacedWithLobName = content.replaceAll("first commit", lob)
        def contentWithEmailSet = replacedWithLobName.replaceAll("README", email)
        return contentWithEmailSet
    }

    static String getJobXml(String dir, String subDir, String name){
        dir = dir.replaceAll(" ", "%20")
        subDir = subDir.replaceAll(" ", "%20")

        def username = "Slava"
        def password = "11e110cc052863bb70d5775e14888c2718"
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/job/${dir}/job/${subDir}/job/${name}/config.xml")
                .method("GET", null)
                .addHeader("Cookie", "JSESSIONID.b1305f6e=node016bienql94kr62spbibbh9v7p5.node0")
                .addHeader("Authorization",  "Basic ${"$username:$password".bytes.encodeBase64()}")
                .build();
        Response response = client.newCall(request).execute();

        return response.body().string()
    }
    static String addJob(String folderName, String subFolderName, String name, String lob, String email){
        def jenkins = Jenkins.instance

        String content = getNewJobXml(folderName, subFolderName, name, lob, email)

        def xmlStream = new ByteArrayInputStream(content.getBytes() )

        def folder = jenkins.getItem(folderName)
        def subFolder = folder.getItem(subFolderName)

        def newName = name.replaceAll("New", "Existing")

        subFolder.createProjectFromXML(newName, xmlStream)
        return newName+ " job successfully created"
    }


}
