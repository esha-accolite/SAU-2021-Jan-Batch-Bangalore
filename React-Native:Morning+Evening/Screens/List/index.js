import React,{ useState,useEffect} from 'react';
import { ScrollView, Text, View, ActivityIndicator, Button, StyleSheet } from 'react-native';
import {NoteCard} from '../../Components';
import AsyncStorage from '@react-native-community/async-storage';
import { useIsFocused } from "@react-navigation/native";
import styles from './styles';

const List = ({navigation}) => {

    const isFocused = useIsFocused();
    // const initialNotes = [
    //     {
    //         "title": "Title 1",
    //         "description": "Description 1"
    //     },
    //     {
    //         "title": "Title 2",
    //         "description": "Description 2"
    //     },
    //     {
    //         "title": "Title 3",
    //         "description": "Description 3"
    //     }
    // ];
    // const n = AsyncStorage.getItem("Notes");
    
    const [Notes, setNotes] = useState([]);

    // let p = route.params | {title:"",description:""};
    // const {a,b} = {...p};

    // const addnotes = () => {
    //     // console.log(a);
    //     // console.log(p.title);
    //     // let cpy = [...Notes,{title:p.title,description:p.description}];
    //     // cpy.sort((a, b) => (a.completeTime > b.completeTime) ? 1 : -1)
    //     // setNotes(cpy);
    //     navigation.navigate("AddNotes");
    // };

      useEffect(() => {
        updateNotes();
      }, [isFocused]);

      const updateNotes = async() => {
        var w = await AsyncStorage.getItem("Notes");
        // if(w!==null){
            w = JSON.parse(w);
        // }
        setNotes(w);
      };

    const deletenote = async(note) => {
        // console.log(note);
        // Notes = await AsyncStorage.getItem("Notes");
        // console.log(Notes);
        // Notes = JSON.parse(Notes);
        let newList = Notes.filter(n => {
            return n.title!==note.title;
        });
        setNotes(newList);
        await AsyncStorage.setItem("Notes", JSON.stringify(newList));
    };


    return (
        <ScrollView >
            <View style={styles.container}>
                <Button style={styles.title} title="Add Note" onPress={() => navigation.navigate("AddNotes", Notes)}/>
                {/* <Text>{JSON.stringify(p)}</Text> */}
                {/* <Text>{JSON.stringify(p.title)}</Text> */}
                {/* {addit(p.title,p.description)} */}
                {/* <NoteCard /> */}
            </View>
            {Notes? (
                Notes.map(note => <NoteCard note = {note} deletenote={deletenote} />)
            ) : (
                <View>
                    {/* <ActivityIndicator size="large" color="blue"/> */}
                    <Text style={styles.emptyscreen}>No notes added!</Text>
                </View>
            )}
        </ScrollView>
    );
};

// const styles = StyleSheet.create({
//     container: {
//       flex: 1,
//       justifyContent: "center",
//       alignItems: "center",
//       marginTop: Platform.OS === 'android' ? 25 : 0,
//       backgroundColor: "black"
//     },
//     title: {
//         flex: 1,
//         flexDirection: "row",
//         justifyContent: "space-around",
//         alignContent: "center"
//     }
// });

export default List;