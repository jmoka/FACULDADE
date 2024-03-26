import { Center, Container, ScrollView } from 'native-base';
import React, { useState } from 'react';
import { Text, TextInput, View, StyleSheet } from 'react-native';
import Micro2 from './micro2';
import Micro3 from './micro3';
import Micro4 from './micro4';
import Micro5 from './micro5';
import AppMP from '../missaoPratica/AppMP';

import Aviso from './aviso';

const Menu = () => {
  const [opcao, setOpcao] = useState('');

  let conteudoComponente;

  if (opcao === '1') {
    conteudoComponente = <Micro2 />;
  } else if (opcao === '2') {
    conteudoComponente = <Micro3 />;
  } else if (opcao === '3') {
    conteudoComponente = <Micro4 />;
  } else if (opcao === '4') {
    conteudoComponente = <Micro5 />;
  } else if (opcao === '5') {
    conteudoComponente = <AppMP />;
  } else if (opcao === '') {
      conteudoComponente = "";
  } else {
    conteudoComponente = <Aviso />;
  }

  return (
    <View style={style.container}>
      <View style={style.cabecalho}>

      <Text style={style.cabecalho}>Faculdade Estácio de Sá</Text>
      <Text style={style.aluno}>João Luiz S Tavares</Text>


      </View>

<Text style={style.textMenu}>Menu</Text>

     <Text style={style.obs}>Escolha uma das opções abaixo</Text>

      <Text style={style.menu}>
        ( 1 ) Microatividade 2 {"\n"}
        ( 2 ) Microatividade 3 {"\n"}
        ( 3 ) Microatividade 4 {"\n"}
        ( 4 ) Microatividade 4 {"\n"}
        ( 5 ) Missão Pratica
      </Text>

      <Text style={style.label}>Digite o número</Text>

      <TextInput
        style={style.input}
        onChangeText={setOpcao}
        placeholder="Digite aqui..."
        keyboardType="numeric"
      />

      {conteudoComponente}

    </View>
  );
};

const style = StyleSheet.create({
  aluno:{color: "red"},
  container: { flex: 1, justifyContent: 'center' },
  cabecalho:{alignItems:'center', fontSize:15, marginTop:20},
  textMenu: { fontSize: 20, marginTop:20, alignSelf: 'center' },
  obs: { fontSize: 15, alignSelf:"center" },
  menu: { marginBottom: 10, fontSize: 15, marginTop: 10 },
  label: { marginBottom: 1, fontSize: 25 },

  input: {
    backgroundColor: '#29292e',
    color: '#f1f1f1',
    fontSize: 18,
    padding: 15,
    marginTop: 2,

    borderRadius: 5,
  },
});

export default Menu;
