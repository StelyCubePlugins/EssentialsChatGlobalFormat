package fr.stelycube.ecgf.permission;

import org.jetbrains.annotations.Nullable;

public interface PermissionLoader {

    @Nullable
    MainGroupRetriever load();

}
