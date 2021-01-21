import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: "center",
      alignItems: "center",
      marginTop: Platform.OS === 'android' ? 25 : 0,
      backgroundColor: "black"
    },
    title: {
        flex: 1,
        flexDirection: "row",
        justifyContent: "space-around",
        alignContent: "center"
    },
    emptyscreen:{
      textAlign: "center",
      fontSize: 10,
      fontWeight: "bold"
    }
});
export default styles;