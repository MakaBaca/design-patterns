package com.scaler.lld.design.assignments.singleton;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {
    
    private static FileBasedConfigurationManagerImpl configMgr = null;

    private FileBasedConfigurationManagerImpl(){
    }
    @Override
    public String getConfiguration(String key) {
        return configMgr.properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String val = configMgr.properties.getProperty(key);
        if(val==null) return null;
        try{
            return type.getConstructor(String.class).newInstance(val);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void setConfiguration(String key, String value) {
        configMgr.properties.setProperty(key,value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        configMgr.properties.setProperty(key, value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        configMgr.properties.remove(key);
    }

    @Override
    public void clear() {
        configMgr.properties.clear();
    }
    
    public static FileBasedConfigurationManager getInstance() {
        if(configMgr == null){
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if(configMgr == null)
                    configMgr = new FileBasedConfigurationManagerImpl();
            }
        }
        return configMgr;
    }

    public static void resetInstance() {
        configMgr = null;
    }

}