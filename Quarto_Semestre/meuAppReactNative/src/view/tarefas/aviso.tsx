import React, { useState } from 'react';
import { Text, View, StyleSheet, TouchableOpacity } from 'react-native';
import VoltarMenu from './menu';

const Aviso = () => {
  const [opcao, setOpcao] = useState('');

  const voltar = () => {
    console.log("Voltando ao menu");

  };

  return (
    <View style={style.container}>
      <Text style={style.aviso}>Erro em sua escolha! </Text>
      <Text style={style.aviso}>Escolha somente de 1 a 3! </Text>
      <TouchableOpacity style={style.botao} onPress={voltar}>
        <Text>Voltar</Text>
      </TouchableOpacity>
    </View>
  );
};

const style = StyleSheet.create({
  container: { flex: 1, justifyContent: 'center', alignItems: 'center' },
  aviso: { fontSize: 18, marginBottom: 10 },
  botao: {
    backgroundColor: '#4CAF50',
    padding: 10,
    borderRadius: 5,
    marginTop: 10,
  },

});

export default Aviso;
