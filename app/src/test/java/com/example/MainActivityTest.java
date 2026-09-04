package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 34)
public class MainActivityTest {

    @Test
    public void testStringsResources() {
        Context context = ApplicationProvider.getApplicationContext();
        assertNotNull(context);
        assertEquals("Transporte e Mapas", context.getString(R.string.app_name));
        assertEquals("Jotur", context.getString(R.string.btn_jotur));
        assertEquals("Fênix", context.getString(R.string.btn_fenix));
        assertEquals("Visualize o mapa da sua região", context.getString(R.string.map_title));
    }
}
