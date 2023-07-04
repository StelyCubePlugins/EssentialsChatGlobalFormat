package fr.stelycube.ecgf.format;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FormatRegistry {

    private final String fallbackFormat;
    private final Map<String, String> groupFormats;

    public FormatRegistry(@NotNull String fallbackFormat, @NotNull Map<String, String> groupFormats) {
        this.fallbackFormat = fallbackFormat;
        this.groupFormats = groupFormats.isEmpty() ? Collections.emptyMap() : new HashMap<>(groupFormats);
    }

    @NotNull
    public String getFormat(@Nullable String group) {
        return group == null ? fallbackFormat : groupFormats.getOrDefault(group, fallbackFormat);
    }

}
