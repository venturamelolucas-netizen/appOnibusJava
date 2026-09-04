package com.example;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

/**
 * MainActivity implementada obrigatoriamente em Java conforme os requisitos.
 */
public class MainActivity extends AppCompatActivity {

    private static final String URL_JOTUR = "https://www.jotur.com.br/horarios/";
    private static final String URL_FENIX = "https://www.consorciofenix.com.br/";
    private static final String URL_MAPS = "https://www.google.com/maps/@-27.6362529,-48.6506496,15z?entry=ttu&g_ep=EgoyMDI2MDkwMi4wIKXMDSoASAFQAw%3D%3D";

    private TabLayout tabLayout;
    private View tabInicioContent;
    private View tabMapasContent;
    private MaterialButton botao1;
    private MaterialButton botao2;
    private ImageButton btnMapPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Suporte a Edge-to-Edge respeitando as barras do sistema
        View rootView = findViewById(R.id.root_layout);
        if (rootView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // Inicialização dos elementos da interface
        tabLayout = findViewById(R.id.tab_layout);
        tabInicioContent = findViewById(R.id.tab_inicio_content);
        tabMapasContent = findViewById(R.id.tab_mapas_content);
        botao1 = findViewById(R.id.botao1);
        botao2 = findViewById(R.id.botao2);
        btnMapPin = findViewById(R.id.btn_map_pin);

        // Configuração dos cliques da aba Início
        if (botao1 != null) {
            botao1.setOnClickListener(v -> abrirUrl(URL_JOTUR));
        }

        if (botao2 != null) {
            botao2.setOnClickListener(v -> abrirUrl(URL_FENIX));
        }

        // Configuração do clique da aba Mapas (alfinete de mapa)
        if (btnMapPin != null) {
            btnMapPin.setOnClickListener(v -> abrirUrl(URL_MAPS));
        }

        // Gerenciamento de navegação entre as abas Início e Mapas
        if (tabLayout != null) {
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int position = tab.getPosition();
                    if (position == 0) {
                        tabInicioContent.setVisibility(View.VISIBLE);
                        tabMapasContent.setVisibility(View.GONE);
                    } else if (position == 1) {
                        tabInicioContent.setVisibility(View.GONE);
                        tabMapasContent.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
        }
    }

    /**
     * Abre uma URL no navegador do dispositivo.
     */
    private void abrirUrl(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Não foi possível abrir o link: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
