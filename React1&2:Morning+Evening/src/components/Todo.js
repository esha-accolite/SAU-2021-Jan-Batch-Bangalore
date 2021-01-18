import React from 'react';

const Todo = ({todo, deleteTodo}) => {
    const del = () => {
        // console.log("del");
        deleteTodo(todo);
    };
    return (
        <ul>
            <li>{todo.title} <button onClick={del}>x</button></li>
        </ul>
    );
};

export default Todo;