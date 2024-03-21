import 'package:flutter/material.dart';
import 'package:myappflutter/view/contatos.dart';
import 'package:myappflutter/view/pacotes.dart';
import 'package:myappflutter/view/microtarefas.dart';

import 'package:myappflutter/main.dart';


void main() {
  runApp(const SobrePage());
}

class SobrePage extends StatelessWidget {
  const SobrePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Agência de Viagens',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const TravelAgencyHomePage(),
    );
  }
}

class TravelAgencyHomePage extends StatelessWidget {
  const TravelAgencyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Agência de Viagens'),
      ),
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            DrawerHeader(
              decoration: const BoxDecoration(
                color: Colors.blue,
              ),
              child: const Text(
                'Menu',
                style: TextStyle(
                  color: Colors.white,
                  fontSize: 24,
                ),
              ),
            ),
            ListTile(
              title: const Text('Voltar'),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MyApp()), 
                );
              },
            ),
            ListTile(
              title: const Text('Micro Tarefas'),
              onTap: () {
                 Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MicroTarefas()),
                );
              },
            ),
            ListTile(
              title: const Text('Pacotes de Viagem'),
              onTap: () {
                 Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Pacotes()), 
                );
              },
            ),
            ListTile(
              title: const Text('Contato'),
              onTap: () {
                 Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Contatos()), 
                );
              },
            ),
            
          ],
        ),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'Sobre',
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
              ),
            ),
            const SizedBox(height: 20),
            const Text(
              'João Luiz Silva Tavares',
              style: TextStyle(
                fontSize: 18,
              ),
            ),
            const Text(
              'Aluno',
              style: TextStyle(
                fontSize: 16,
              ),
            ),
            const SizedBox(height: 20),
            const Text(
              'Matrícula : 202208681182.',
              textAlign: TextAlign.center,
            ),
          ],
        ),
      ),
    );
  }

  Widget _buildDestinationCard(String title, String imagePath, String description) {
    return Card(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          Container(
            height: 200, // Defina o tamanho desejado da imagem aqui
            child: Image.asset(
              imagePath,
              fit: BoxFit.cover,
            ),
          ),
          ListTile(
            title: Text(title),
            subtitle: Text(description),
          ),
        ],
      ),
    );
  }
}
