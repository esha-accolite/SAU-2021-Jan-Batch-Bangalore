import React, {useState} from 'react';

const NewTodo = ({ addTodo }) => {
    const [ userInput, setUserInput ] = useState('');
    const [ userDate, setUserDate ] = useState(new Date());

    const onAddTitle = (event) => {
        // console.log("added title!");
        setUserInput(event.currentTarget.value);
    };

    const onAddDate = (event) => {
        // console.log("added date!");
        setUserDate(event.currentTarget.value);
    };

    const onsubmit = (event) => {
        event.preventDefault();
        addTodo(userInput,userDate);
        setUserInput("");
        setUserDate(new Date());
    };
    return (
        // <p>NewTodo works!</p>
        <form>
            <input type="text" value={userInput} placeholder="Add todo..." onChange={onAddTitle}/>
            <input type="date" value={userDate} onChange={onAddDate}/>
            <button type="submit" onClick={onsubmit}>Add</button>
        </form>
    );
};

export default NewTodo;