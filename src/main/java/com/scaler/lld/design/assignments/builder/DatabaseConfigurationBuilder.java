package com.scaler.lld.design.assignments.builder;

@WithBuilder
public class DatabaseConfigurationBuilder {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    private DatabaseConfigurationBuilder(){

    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{

        private DatabaseConfigurationBuilder obj = new DatabaseConfigurationBuilder();
        private Builder(){}

        public Builder setDatabaseUrl(String url){
            obj.databaseUrl = url;
            return this;
        }

        public Builder setUserName(String name){
            obj.username = name;
            return this;
        }

        public Builder setPassword(String pwd){
            obj.password = pwd;
            return this;
        }

        public Builder setMaxConnection(int cnt){
            obj.maxConnections = cnt;
            return this;
        }

        public Builder setEnableCache(boolean isEnable){
            obj.enableCache = isEnable;
            return this;
        }

        public Builder setIsReadOnly(boolean isReadOnly){
            obj.isReadOnly = isReadOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
            return obj;
        }
    }

}