import 'package:flutter/material.dart';
import 'package:myappflutter/view/pacotes.dart';
import 'package:myappflutter/view/sobre.dart';
import 'package:carousel_slider/carousel_slider.dart';
import 'package:myappflutter/main.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:myappflutter/view/microtarefas.dart';


void main() {
  runApp(const Contatos());
}

class Contatos extends StatelessWidget {
  const Contatos({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Meu App Flutter',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: const TravelAgencyHomePage(),
      routes: {
        '/voltar': (context) => HomeScreen(),
      },
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
              title: const Text('Sobre Nós'),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SobrePage()), 
                );
              },
            ),
          ],
        ),
      ),
      body: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: const [
            Text('Missão Prática | Nível 2 | Mundo 4'),
            Text('João Luiz Silva Tavares'),
          ],
        ),
      ),
      body: Container(
        decoration: const BoxDecoration(
          gradient: LinearGradient(
            begin: Alignment.topCenter,
            end: Alignment.bottomCenter,
            colors: [
              Color.fromARGB(255, 55, 2, 243),
              Color.fromARGB(255, 100, 176, 246),
            ],
          ),
        ),
        child: Padding(
          padding: const EdgeInsets.all(5),
          child: ListView(
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
              const SizedBox(height: 10),
               Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        _buildButton(context, Icons.call, 'WhatsApp', 'https://wa.me/5591996293532'),
                        _buildButton(context, Icons.near_me, 'Voltar', '/voltar'), // Usando a rota '/home'
                        _buildButton(context, Icons.share, 'Instagram', 'https://www.instagram.com/jotaempresas/?hl=de'),
                      ],
                    ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 2),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: const [
                    Text(
                      'Faculdade Estácio de Sá',
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 24,
                        color: Colors.white,
                      ),
                    ),
                    SizedBox(height: 8),
                    Text(
                      'Curso Fullstack',
                      style: TextStyle(
                        color: Colors.grey,
                      ),
                    ),
                    SizedBox(height: 20),
                    Text(
                      'Objetivos da prática',
                      style: TextStyle(fontSize: 25, color: Color.fromARGB(255, 255, 1, 1)),
                    ),
                    Text(
                      '* Instalar e configurar o Flutter SDK e o ambiente de desenvolvimento integrado (IDE) de acordo com as melhores práticas',
                      style: TextStyle(fontSize: 14, color: Color.fromARGB(255, 123, 216, 1)),
                    ),
                    Text(
                      '* Empregar Widgets fundamentais, como MaterialApp, Scaffold, AppBar, Text e RaisedButton',
                      style: TextStyle(fontSize: 14, color: Color.fromARGB(255, 226, 230, 7)),
                    ),
                    Text(
                      '* Aplicar diferentes Widgets para criar uma interface visual atraente e funcional',
                      style: TextStyle(fontSize: 14, color: Color.fromARGB(255, 22, 22, 22)),
                    ),
                    Text(
                      '* Aplicar o widget ListView para exibir e gerenciar listas de dados',
                      style: TextStyle(fontSize: 14, color: Color.fromARGB(255, 176, 2, 245)),
                    ),
                    Text(
                      '* Criar e implementar funcionalidades personalizadas para um Widget específico.',
                      style: TextStyle(fontSize: 14, color: Color.fromARGB(255, 248, 149, 0)),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
Widget _buildButton(BuildContext context, IconData icon, String label, String url) {
    return InkWell(
      onTap: () async {
        // Handle button tap (open link)
        if (url.startsWith('http')) {
          if (await canLaunch(url)) {
            await launch(url);
          } else {
            throw 'Could not launch $url';
          }
        } else {
          // Navigate to the desired page
          Navigator.pushNamed(context, url);
        }
      },
      child: Column(
        children: [
          Container(
            padding: const EdgeInsets.all(12),
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(8),
            ),
            child: Icon(icon, color: Colors.blue),
          ),
          const SizedBox(height: 8),
          Text(
            label,
            style: const TextStyle(
              color: Colors.white,
              fontWeight: FontWeight.bold,
            ),
          ),
        ],
      ),
    );
  }
class HomeScreen extends StatelessWidget {
  const HomeScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Voltar'),
      ),
      body: Center(
        child: InkWell(
          onTap: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => MyApp()), 
            );
          },
          child: MyApp(), 
        ),
      ),
    );
  }
}