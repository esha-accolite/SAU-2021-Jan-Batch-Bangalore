import React from 'react';
import { Text, View, TouchableOpacity, ImageBackground, StyleSheet, Button } from 'react-native';
import styles from './styles';

const NoteCard = ({note, deletenote}) => {

    const delnote = (event) => {
        event.preventDefault();
        deletenote(note);
    };

    return (
        <TouchableOpacity style={styles.container}>
                <Text style={styles.textup}>{note.title}</Text>
                <Text style={styles.textbottom}>{note.description}</Text>
                <Text />
                <Text />
                <Button style={styles.btn} title="Delete" onPress={delnote}/>
        </TouchableOpacity>    
    );
};

// const styles = StyleSheet.create({
//     container: {
//         width: "95%",
//         height: 150,
//         marginLeft: "2.5%",
//         marginRight: "2.5%",
//         marginVertical: 10,
//         backgroundColor: "#ADD8E6",
//         borderRadius: 10
//     },
//     btn:{
//         position: "relative",
//         right:0,
//         alignSelf:"flex-end"
//     },
//     textup:{
//         fontWeight: "bold",
//         fontSize: 30,
//         paddingLeft: "5%",
//         paddingTop: "2%"
//     },
//     textbottom:{
//         // fontWeight: "bold",
//         fontSize: 20,
//         paddingLeft: "5%",
//         paddingTop: "2%"
//     }
// });

export default NoteCard;