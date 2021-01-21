import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: "center",
      alignItems: "center",
      backgroundColor: "grey"
    //   paddingTop: 60,
    },
    textInputStyle: {
      borderColor: "black",
      borderWidth: 2,
      borderRadius: 25,
      fontSize: 20,
      padding: 12,
      width: 300,
      marginBottom: 20,
    },
    desc:{
        height: 200,
        width: 300,
        borderColor: "black",
        borderWidth: 2,
        borderRadius: 25,
        fontSize: 20,
        padding: 12,
        marginBottom: 20
    }
});

export default styles;