package com.recifemecatron.lio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;

import cielo.orders.domain.Order ;
import cielo.orders.domain.Credentials;
import cielo.sdk.order.OrderManager;
import cielo.sdk.order.ServiceBindListener;
import  android.view.View;
import android.widget.Toast;
import android.content.Context;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        Credentials credenciais = new Credentials("G8lcvrxEdK045SsxiazLHbiVagCVfMeQb7le2XGLBKq8eUnLGe/ Vn2EbH8IgJSHN8ZlcD4iXTYR5sN0WLEppv9kHGoCr1IOr43rOL", "hEUjxMkLkDijYS1s9Zr7ypxHHIadHZRX1pp8KjZn17SRxI3n8e");
        OrderManager orderManager = new OrderManager(credenciais, MainActivity.this);
        orderManager.bind(MainActivity.this, serviceBindListener);
        */

/*
        Context contexto = getApplicationContext();
        String texto = "Iniciou o OrderManeger";
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();
        */
    }

    public void clique_lio(View view){

        Credentials credenciais = new Credentials("G8lcvrxEdK045SsxiazLHbiVagCVfMeQb7le2XGLBKq8eUnLGe/ Vn2EbH8IgJSHN8ZlcD4iXTYR5sN0WLEppv9kHGoCr1IOr43rOL", "hEUjxMkLkDijYS1s9Zr7ypxHHIadHZRX1pp8KjZn17SRxI3n8e");
        OrderManager orderManager = new OrderManager(credenciais, MainActivity.this);
        orderManager.bind(MainActivity.this, serviceBindListener);

        Order order = orderManager.createDraftOrder("123456");

        // Dados do produto teste
        String sku = "2891820317391823";
        String name = "Coca-cola lata";

        // Preço do produto
        int unitPrice = 550;
        int quantity = 3;

        // Unidade de medida do produto
        String unityOfMeasure = "UNIDADE";

        order.addItem(sku, name, unitPrice, quantity, unityOfMeasure);
        orderManager.placeOrder(order);

    }

    ServiceBindListener serviceBindListener = new ServiceBindListener() {

        @Override public void onServiceBoundError(Throwable throwable) {

            Context contexto = getApplicationContext();
            String texto = "Ocorreu um erro ao tentar se conectar com o serviço OrderManager";
            int duracao = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();

        }

        @Override
        public void onServiceBound() {
            Context contexto = getApplicationContext();
            String texto = "Funções do OrderManeger na moral";
            int duracao = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }

        @Override
        public void onServiceUnbound() {
            Context contexto = getApplicationContext();
            String texto = "O serviço foi desvinculado";
            int duracao = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    };




}
