import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';



import Csimples from "./ComponenteSimples";
import Ecomponente from "./ElementoComponente";
import Propst from "./Propst";
import UsandoImagens from "./UsandoImagens";

export default function AppMP() {
  const num = 1;
  return (
    <View style={styles.container}>
      <Csimples/>
      <Ecomponente/>
      <Propst/>
      <UsandoImagens/>
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
