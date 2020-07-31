package com.recifemecatron.lio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cielo.orders.domain.Credentials;
import cielo.sdk.order.OrderManager;
import cielo.sdk.order.ServiceBindListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Credentials credenciais = new Credentials("Seu client id", "Seu accessToken aqui");

        OrderManager orderManager = new OrderManager(credenciais, MainActivity.this);

        orderManager.bind(MainActivity.this, serviceBindListener);
    }

    ServiceBindListener serviceBindListener = new ServiceBindListener() {

        @Override public void onServiceBoundError(Throwable throwable) {
            //Ocorreu um erro ao tentar se conectar com o serviço OrderManager
        }

        @Override
        public void onServiceBound() {
            //Você deve garantir que sua aplicação se conectou com a LIO a partir desse listener
            //A partir desse momento você pode utilizar as funções do OrderManager, caso contrário uma exceção será lançada.
        }

        @Override
        public void onServiceUnbound() {
            // O serviço foi desvinculado
        }
    };
}
