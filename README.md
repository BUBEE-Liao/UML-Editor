# UML Editor

A lightweight UML editor designed to create, manage, and edit UML diagrams with ease. This project implements the core functionalities of a UML editor as specified in the requirement document.

![image](https://github.com/BUBEE-Liao/UML-Editor/blob/main/UML.png)

---

![image](https://github.com/BUBEE-Liao/UML-Editor/blob/main/view.jpg)

---

## 🚀 Features

### Object Creation
- **Basic Objects**: Create UML elements like **Class** and **Use Case** diagrams.
- **Connection Lines**: Support for **Association**, **Generalization**, and **Composition** lines with precise port-based connections.

### Object Management
- **Select/Unselect**:
  - Single object or group of objects.
  - Display connection ports for selected objects.
- **Group/Ungroup**:
  - Combine multiple basic objects into a composite object.
  - Decompose composite objects back into individual components.

### Object Interaction
- **Move Objects**: Drag and drop objects while maintaining connected lines.
- **Edit Object Names**: Rename selected objects using a text input dialog.
- **Delete Objects**: Remove selected objects or lines from the canvas.

### Additional Functionalities
- **Object Depth**: Render overlapping objects based on depth hierarchy.
- **User-friendly UI**: Button-based mode switching for object and line creation.

---

## 🛠️ Technologies Used
- **Programming Language**: Java
- **Framework**: Swing/JavaFX (for GUI development)
- **Design Paradigm**: Object-Oriented Design and UML principles

---
## 📋 Use Cases

### 1. Creating Objects
- **Precondition**: User selects `Class` or `Use Case` button.
- **Steps**:
  1. Click the button (turns active).
  2. Click on the canvas to create the object at the clicked position.
- **Alternative**: Clicking another button switches to its mode.

### 2. Creating Connections
- **Precondition**: User selects a connection line type (e.g., `Association`).
- **Steps**:
  1. Click and drag from one object to another.
  2. Release to establish the connection with appropriate line styles.

### 3. Selecting Objects
- **Single Select**:
  - Click an object to highlight it.
- **Group Select**:
  - Drag a rectangle to select multiple objects.
  - All objects fully enclosed within the rectangle are selected.

### 4. Grouping/Ungrouping
- **Group**:
  - Select multiple objects and choose `Group` from the `Edit Menu`.
- **Ungroup**:
  - Select a composite object and choose `Ungroup` from the `Edit Menu`.

### 5. Moving Objects
- Drag and drop selected objects.
- Connections adjust dynamically based on the new position.

### 6. Editing Object Names
- Select an object, open the `Edit Menu`, and choose `Change Object Name`.

### 7. Deleting Objects
- Select an object or connection, and delete it via the `Edit Menu`.

---

## 🛠️ Installation & Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/UML-Editor.git
   cd UML-Editor
   ```
