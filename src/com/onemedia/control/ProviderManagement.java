package com.onemedia.control;

import java.util.ArrayList;

public class ProviderManagement {

    public ProviderManagement() {
        providers = new ArrayList<>();
    }

    public boolean addProvider(Provider provider) {
        if (provider == null) return false;
        for (int i=0; i < providers.size(); i++) {
            Provider o = providers.get(i);
            if (o.getIdCode().equals(provider.getIdCode()))
                return false;
        }
        providers.add(provider);
        return true;
    }

    public Provider rmvProvider(String idCode) {
        for (int i=0; i < providers.size(); i++) {
            Provider provider = providers.get(i);
            if (provider.getIdCode().equals(idCode)) {
                providers.remove(i);
                return provider;
            }
        }
        return null;
    }

    public boolean providerExisted(String idCode) {
        for (int i=0; i < providers.size(); i++) {
            Provider provider = providers.get(i);
            if (provider.getIdCode().equals(idCode))
                return true;
        }
        return false;
    }

    public Provider getProviderById(String idCode) {
        for (int i=0; i < providers.size(); i++) {
            Provider provider = providers.get(i);
            if (provider.getIdCode().equals(idCode))
                return provider;
        }
        return null;
    }

    public void printInfo() {
        for (Provider o : providers) {
            o.printInfo();
        }
    }

    private ArrayList<Provider> providers;
}
