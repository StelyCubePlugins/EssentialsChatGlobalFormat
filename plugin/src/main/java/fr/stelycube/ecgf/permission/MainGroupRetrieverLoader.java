package fr.stelycube.ecgf.permission;

import fr.stelycube.ecgf.permission.luckperms.LuckPermsLoader;

public class MainGroupRetrieverLoader {

    public MainGroupRetriever load() {
        final PermissionLoader[] loaders = new PermissionLoader[]{
                new LuckPermsLoader()
        };
        for (PermissionLoader loader : loaders) {
            final MainGroupRetriever mainGroupRetriever = loader.load();
            if (mainGroupRetriever == null) {
                continue;
            }
            return mainGroupRetriever;
        }
        return new DummyMainGroupRetriever();
    }

}
