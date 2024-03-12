import React from 'react';

import { Text, View } from 'react-native';



const Cat = (props: { name: string | null | undefined; }) => {

  return (

    <View>

      <Text>Hello, I am {props.name}!</Text>

    </View>

  );

};



const Cafe = () => {

  return (

    <View>

      <Cat name="Maru" />

      <Cat name="Jellylorum" />

      <Cat name="Spot" />

    </View>

  );

};



export default Cafe;
