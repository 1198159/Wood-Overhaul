package com.I198159.util;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import java.util.Set;
import java.util.stream.Stream;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.SignType;

public class CustomSignType extends SignType {
    public CustomSignType(String name) {
        super(name);
    }
}
