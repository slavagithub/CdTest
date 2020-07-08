interface ConfigProcessor {

    void setUpdateDetails(UpdateDetails config)

    void updateContent()

    void setContent(Object configContent)

    Object getUpdated()

    String getFileId()

    String getFileName()

    String getFileComment()

}