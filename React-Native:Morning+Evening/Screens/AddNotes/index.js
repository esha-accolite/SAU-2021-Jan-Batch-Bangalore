import React, { useState } from 'react';
import { Button, ScrollView, TextInput, StyleSheet, View } from 'react-native';
import AsyncStorage from '@react-native-community/async-storage';
import styles from './styles';

const AddNotes = ({navigation}) => {

    // let {...Notes} = route.params;

    const [titl, setTitl] = useState("");
    const [desc, setDesc] = useState("");

    const shownotes = async(event) => {
        // console.log(title);
        // console.log(desc);
        event.preventDefault();
        const n = {
            "title":titl,
            "description":desc
        };
        var Notes = await AsyncStorage.getItem("Notes");
        // console.log(JSON.parse(Notes))
        if(Notes===null)
        {
            Notes = JSON.parse(Notes);
            Notes = [
                {
                    "title":titl,
                    "description":desc
                }
            ];
        }
        else{
            Notes = JSON.parse(Notes);
            Notes.push(n);
        }
        // console.log(Notes);
        await AsyncStorage.setItem('Notes', JSON.stringify(Notes));
        // let cpy = [...Notes,{title:titl,description:desc}];
        // console.log(Notes);
        // setNotes(cpy);
        // console.log(n.title);
        // addN();
        navigation.navigate("List");
    };
    
    return (
        <View style={styles.container}>
            <TextInput style={styles.textInputStyle} placeholder="Title..." onChangeText={(text) => setTitl(text)}/>
            <TextInput style={styles.desc} placeholder="Description..." onChangeText={(text) => setDesc(text)}/>
            <Button title="Add Note" onPress={shownotes}/>
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
//     textInputStyle: {
//       borderColor: "black",
//       borderWidth: 2,
//       borderRadius: 25,
//       fontSize: 20,
//       padding: 12,
//       width: 300,
//       marginBottom: 20,
//     },
//     desc:{
//         height: 200,
//         width: 300,
//         borderColor: "black",
//         borderWidth: 2,
//         borderRadius: 25,
//         fontSize: 20,
//         padding: 12,
//         marginBottom: 20
//     }
// });

export default AddNotes;