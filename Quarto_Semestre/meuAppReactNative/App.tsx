import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View, ScrollView } from 'react-native';


import Menu from "./src/view/tarefas/menu";
import Csimples from "./src/view/missaoPratica/ComponenteSimples";

// ESCOLHA QUAL TAREFA GOSTARIA DE APRESENTAR
// E SÓ TRACAR A NUMERAÇÃO (Micro?)
// DE 2 A 4
export default function App() {
  const num = 1;
  return (

    <View style={styles.container}>
      <Menu/>
    </View>

  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'yellow',
  },
  text: {
    color: 'black',
    fontSize: 18,

  }

});
