import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    container: {
      flex: 1,
      justifyContent: "center",
      alignItems: "center",
    //   paddingTop: 60,
    },
    loginTextStyle: {
      fontSize: 25,
      fontWeight: "700",
      marginVertical: 20
    },
    textInputStyle: {
      borderColor: "black",
      borderWidth: 2,
      borderRadius: 25,
      fontSize: 20,
      padding: 12,
      width: 300,
      marginBottom: 20
    }
});

export default styles;