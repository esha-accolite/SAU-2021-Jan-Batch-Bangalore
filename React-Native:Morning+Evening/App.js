import React from 'react';
import { Text, View, StyleSheet } from 'react-native';
import { Login, List, AddNotes } from './Screens';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Login">
        <Stack.Screen name="Login" component={Login} />
        <Stack.Screen name="List" component={List} />
        <Stack.Screen name="AddNotes" component={AddNotes} />
      </Stack.Navigator>
    </NavigationContainer>
    // <View style={styles.container}>
    //   <Text>hey Esha!</Text>
    //   {/* <Login /> */}
    //   <List />
    //   {/* <AddNotes /> */}
    // </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  }
});

export default App;
