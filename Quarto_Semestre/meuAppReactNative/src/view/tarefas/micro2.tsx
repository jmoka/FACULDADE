import React, { useState } from 'react';
import { Text, TextInput, View, StyleSheet } from 'react-native';

const PizzaTranslator = () => {
  const [text, setText] = useState('');

  return (

      <View style={style.container}>
        <Text style={style.divisao}>===================================</Text>
        <Text style={style.titulo}>
        Microatividade 2
        </Text>
        <Text style={style.label}>
          Digite o Texto para Tradução
        </Text>
        <TextInput
          style={style.input}
          placeholder="Digite aqui.."
          placeholderTextColor="white"
          onChangeText={(newText) => setText(newText)}

        />

        <Text style={style.textTraducao}>
          Tradução logo abaixo
        </Text>
        <Text style={style.traducao}>

{text

  .split(' ')

  .map(word => word && '🍕')

  .join(' ')}

</Text>
<Text style={style.divisao}>===================================</Text>
      </View>

  );
};


const style = StyleSheet.create({
  container:{ flex: 1, padding: 10, justifyContent: 'center'},
  titulo:{ marginBottom: 10, fontSize: 30, height: 40 },
  label:{ marginBottom: 5, fontSize: 20, height: 30 },
  input :{
    height: 60,
    fontSize: 20,
    borderWidth: 1,
    borderColor: 'gray',
    padding: 8,
    textAlign: 'left',
    color: 'white',
    backgroundColor: 'gray',
    borderRadius: 10,
  },
  divisao: { height: 40, fontSize: 20 },
  textTraducao: { marginBottom: 5, fontSize: 20, height: 30 },
  traducao: {padding: 10, fontSize: 42}
})

export default PizzaTranslator;
