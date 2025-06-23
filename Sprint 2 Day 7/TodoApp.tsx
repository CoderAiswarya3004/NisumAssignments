import React, { useState } from "react";

type TodoId = number;
type Filter = "all" | "completed" | "pending";

enum TodoStatus {
  PENDING = "PENDING",
  COMPLETED = "COMPLETED"
}

interface TodoItem {
  id: TodoId;
  title: string;
  completed: boolean;
  status: TodoStatus;
  description?: string;
}

type TodoList = TodoItem[];
type AddTodo = (title: string, description?: string | null) => void;

type TodoMeta<T> = T extends TodoItem ? { createdAt: Date } : never;
type Nullable<T> = T | null;
type TodoOptionalMap = {
  [K in keyof TodoItem]?: TodoItem[K];
};

function identity<T>(value: T): T {
  return value;
}

function isTodo(obj: any): obj is TodoItem {
  return typeof obj?.id === "number" && typeof obj?.title === "string";
}

const TodoApp: React.FC = () => {
  const [todos, setTodos] = useState<TodoList>([]);
  const [input, setInput] = useState<string>("");
  const [desc, setDesc] = useState<Nullable<string>>(null);
  const [filter, setFilter] = useState<Filter>("all");

  const addTodo: AddTodo = (title, description) => {
    const newTodo: TodoItem = {
      id: identity(Date.now()),
      title,
      completed: false,
      status: TodoStatus.PENDING,
      description: description || undefined
    };
    setTodos([...todos, newTodo]);
    setInput("");
    setDesc(null);
  };

  const toggleTodo = (id: TodoId): void => {
    setTodos(prev =>
      prev.map(todo =>
        todo.id === id
          ? {
              ...todo,
              completed: !todo.completed,
              status: !todo.completed ? TodoStatus.COMPLETED : TodoStatus.PENDING
            }
          : todo
      )
    );
  };

  const filteredTodos: TodoList = todos.filter(todo => {
    if (filter === "completed") return todo.status === TodoStatus.COMPLETED;
    if (filter === "pending") return todo.status === TodoStatus.PENDING;
    return true;
  });

  return (
    <div className="p-4 max-w-xl mx-auto">
      <h2 className="text-2xl font-bold mb-4">To-Do App (TypeScript + React)</h2>

      <div className="flex gap-2 mb-2">
        <input
          type="text"
          placeholder="Task title"
          value={input}
          onChange={e => setInput((e.target as HTMLInputElement).value)}
          className="border px-2 py-1"
        />
        <input
          type="text"
          placeholder="Optional description"
          value={desc || ""}
          onChange={e => setDesc((e.target as HTMLInputElement).value)}
          className="border px-2 py-1"
        />
        <button
          onClick={() => addTodo(input, desc)}
          className="bg-blue-600 text-white px-4 rounded"
        >
          Add
        </button>
      </div>

      <div className="mb-4">
        <span>Filter: </span>
        {(["all", "completed", "pending"] as const).map(f => (
          <button
            key={f}
            onClick={() => setFilter(f)}
            className={`px-2 ${filter === f ? "font-bold underline" : ""}`}
          >
            {f}
          </button>
        ))}
      </div>

      <ul className="space-y-2">
        {filteredTodos.map(todo =>
          isTodo(todo) ? (
            <li
              key={todo.id}
              className="border p-3 flex justify-between items-center rounded"
            >
              <div>
                <h3 className="font-semibold">
                  {todo.title} ({todo.status})
                </h3>
                {todo.description && <p className="text-sm">{todo.description}</p>}
              </div>
              <button
                className="bg-green-500 text-white px-2 rounded"
                onClick={() => toggleTodo(todo.id)}
              >
                Toggle
              </button>
            </li>
          ) : (
            <li key={String(todo.id)}>Invalid Todo</li>
          )
        )}
      </ul>
    </div>
  );
};

export default TodoApp;

