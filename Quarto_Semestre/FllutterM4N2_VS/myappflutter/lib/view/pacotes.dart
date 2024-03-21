import 'package:flutter/material.dart';
import 'package:myappflutter/view/sobre.dart';
import 'package:myappflutter/view/contatos.dart';
import 'package:myappflutter/main.dart';
import 'package:myappflutter/view/microtarefas.dart';


void main() {
  runApp(const Pacotes());
}

class Pacotes extends StatelessWidget {
  const Pacotes({Key? key}) : super(key: key);

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
        title: Text('Agência de Viagens'),
      ),
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            DrawerHeader(
              decoration: BoxDecoration(
                color: Colors.blue,
              ),
              child: Text(
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
          _buildDestinationCard('Mosqueiro / PA', 'lib/images/lake6.jpg', 'Conheça as belas praias e paisagens Mosqueiro/PA.'),
          _buildDestinationCard('Paris', 'lib/images/lake5.jpg', 'Explore a cultura e a arquitetura romântica de Paris.'),
          _buildDestinationCard('Tóquio', 'lib/images/lake4.jpg', 'Descubra a modernidade e a tradição de Tóquio.'),
        ],
      ),
    );
  }

  Widget _buildDestinationCard(String title, String imagePath, String description) {
    return Card(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          Image.asset(
            imagePath,
            fit: BoxFit.cover,
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
