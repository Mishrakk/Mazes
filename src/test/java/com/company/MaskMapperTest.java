package com.company;

import com.company.Model.Mask;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class MaskMapperTest {
    @Test
    public void testSimpleMask() throws FileNotFoundException, URISyntaxException {
        Random random = new Random();
        MaskMapper maskMapper = new MaskMapper(random);
        URI fileUri = Objects.requireNonNull(getClass().getClassLoader().getResource("masks/simple_mask.txt")).toURI();

        Mask mask = maskMapper.FromTextFile(fileUri);
        Assert.assertEquals("All non-X's are marked enabled",8, mask.getEnabledCells());
        Assert.assertFalse("All X's are marked disabled", mask.isCellEnabled(1,1));
    }
}
