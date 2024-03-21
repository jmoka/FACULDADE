import 'package:flutter/material.dart';
import 'package:myappflutter/view/sobre.dart';
import 'package:myappflutter/view/contatos.dart';
import 'package:myappflutter/view/pacotes.dart';
import 'package:myappflutter/view/microtarefas.dart';

import 'package:carousel_slider/carousel_slider.dart';


void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

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
            ListTile(
              title: const Text('Sobre Nós'),
              onTap: () {
                 Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SobrePage()), 
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
          ],
        ),
      ),
      body: ListView(
        children: [
          CarouselSlider(
            items: [
              Image.asset(
                'lib/images/lake.png',
                fit: BoxFit.cover,
              ),
              Image.asset(
                'lib/images/lake1.jpg',
                fit: BoxFit.cover,
              ),
              Image.asset(
                'lib/images/lake2.jpg',
                fit: BoxFit.cover,
              ),
              Image.asset(
                'lib/images/lake3.jpg',
                height: 50,
                fit: BoxFit.cover,
              ),
            ],
            options: CarouselOptions(
              autoPlay: true,
              enlargeCenterPage: true,
              aspectRatio: 16 / 8,
              viewportFraction: 0.8,
            ),
          ),
          const SizedBox(height: 20),
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const Text(
                  'Bem-vindo à Empresa de Viagens',
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 24,
                  ),
                ),
                const SizedBox(height: 10),
                const Text(
                  'Oferecemos experiências de viagem excepcionais para os destinos mais incríveis do mundo.',
                  style: TextStyle(fontSize: 16),
                ),
                const SizedBox(height: 20),
                ElevatedButton(
                  onPressed: () {
                    
                 Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Pacotes()), 
                );
            
                  },
                  child: const Text('Explore nossos pacotes de viagem'),
                ),
              ],
            ),
          ),
        ],
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
