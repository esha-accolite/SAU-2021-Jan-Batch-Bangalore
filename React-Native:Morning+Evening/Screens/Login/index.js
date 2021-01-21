import React, { useState, useEffect } from 'react';
import { View, StyleSheet, TextInput, Text, Button } from 'react-native';
// import {AsyncStorage} from '@react-native-community/async-storage';
import AsyncStorage from '@react-native-community/async-storage';
import styles from './styles';

const Login = ({navigation}) => {

  const [username, setUsername] = useState("");
  // console.log(username);

  useEffect(() => {
    isloggedIn();
  }, []);

  const isloggedIn = async () => {
    const username = await AsyncStorage.getItem("username");
    console.log(username);
    if (username) {
      navigation.navigate("List");
    }
    return;
  };

  const login = async () => {
    await AsyncStorage.setItem("username", username);
    // console.log(username);
    navigation.navigate("List");
  }

    return (
        <View style={styles.container}>
            <Text style={styles.loginTextStyle}>Login</Text>
            <TextInput style={styles.textInputStyle} placeholder=" username..." onChangeText={(text) => setUsername(text)} />
            {/* <TextInput style={styles.textInputStyle} placeholder=" password..." /> */}
            <Button title="Sign In" onPress={login} />
        </View>
    );
};

// const styles = StyleSheet.create({
//     container: {
//       flex: 1,
//       justifyContent: "center",
//       alignItems: "center",
//     //   paddingTop: 60,
//     },
//     loginTextStyle: {
//       fontSize: 25,
//       fontWeight: "700",
//       marginVertical: 20
//     },
//     textInputStyle: {
//       borderColor: "black",
//       borderWidth: 2,
//       borderRadius: 25,
//       fontSize: 20,
//       padding: 12,
//       width: 300,
//       marginBottom: 20
//     }
// });
  

export default Login;