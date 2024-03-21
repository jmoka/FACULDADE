import 'package:flutter/material.dart';

void main() {
  runApp(const MicroTarefas());
}

class MicroTarefas extends StatelessWidget {
  final String appBarTitle;

  const MicroTarefas({Key? key, this.appBarTitle = 'MicroTarefas'}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(appBarTitle),
      ),
      body: ListView(
        children: [
          Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text('Macoratti .net'),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  Column(
                    children: <Widget>[Icon(Icons.call), Text('Call')],
                  ),
                  Column(
                    children: <Widget>[Icon(Icons.directions), Text('Route')],
                  ),
                  Column(
                    children: <Widget>[Icon(Icons.share), Text('Share')],
                  ),
                ],
              ),
            ],
          ),
          ListTile(
            title: Text('Flutter'),
            subtitle: Text('Tudo é um widget'),
            leading: Icon(Icons.flash_on),
            trailing: Icon(Icons.keyboard_arrow_right),
          ),
          ListTile(
            title: Text('Dart'),
            subtitle: Text('É fácil'),
            leading: Icon(Icons.mood),
            trailing: Icon(Icons.keyboard_arrow_right),
          ),
          ListTile(
            title: Text('Firebase'),
            subtitle: Text('Combina com Flutter'),
            leading: Icon(Icons.whatshot),
            trailing: Icon(Icons.keyboard_arrow_right),
          ),
          Stack(
            children: [
              Container(
                width: 250,
                height: 250,
                color: Colors.blue,
              ),
              Container(
                width: 200,
                height: 200,
                color: Colors.red,
              ),
              Container(
                width: 150,
                height: 150,
                color: Colors.yellow,
              ),
            ],
          ),
        ],
      ),
    );
  }
}
