import { Flex } from 'native-base';
import React from 'react';
import { View, Image, StyleSheet, Text } from 'react-native';

const styles = StyleSheet.create({
  container1: {
    flexDirection: 'row', // Define a direção do flex como linha (horizontal)
  },
  container: {
    flex: 1, // Faz com que cada contêiner ocupe a mesma quantidade de espaço disponível
    padding: 16, // Adiciona algum espaço ao redor dos elementos
  },
  tinyLogo: {
    width: 50,
    height: 50,
  },
  logo: {
    width: 66,
    height: 58,
  },
  text: {
    fontSize: 20,
  },
});

const DisplayAnImage = () => {
  return (
    <View style={styles.container1}>
      <View style={styles.container}>
        <Text style={styles.text}>Imagem externas</Text>

        <Image
          style={styles.tinyLogo}
          source={{
            uri: 'https://blog.logrocket.com/wp-content/uploads/2021/12/building-custom-dropdown-react-native.png',
          }}
        />
        <Image
          style={styles.logo}
          source={{
            uri: 'https://blog.logrocket.com/wp-content/uploads/2021/12/building-custom-dropdown-react-native.png',
          }}
        />
      </View>

      <View style={styles.container}>
        <Text style={styles.text}>Imagem do Diretório</Text>

        <Image
          style={styles.tinyLogo}
          source={require('../imag/logo.png')}
        />
        <Image
          style={styles.logo}
          source={require('../imag/logo.png')}
        />
      </View>
    </View>
  );
};

export default DisplayAnImage;
