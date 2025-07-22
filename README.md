# Symptom-Based Health Assistant

This is a full-stack web application designed to assist users in identifying potential health conditions based on their symptoms. The application provides a probable diagnosis, a percentage match, recommended precautions, and the type of specialist to consult.

## Features

-   **Interactive Symptom Selection:** Users start by selecting from a list of common symptoms.
-   **Dynamic Symptom Filtering:** As a user selects symptoms, the application suggests other related symptoms to help narrow down the diagnosis.
-   **Disease Prediction:** A backend algorithm calculates and returns the most likely disease with a match percentage.
-   **Detailed Results:** Displays the predicted disease, necessary precautions, and the appropriate type of doctor to consult.
-   **Light/Dark Mode:** A theme-switcher for user comfort.

## Tech Stack

| Category      | Technology                               	    |
| ------------- | --------------------------------------------- |
| **Backend**   | Java, Spring Boot, Spring Data JPA, Hibernate |
| **Frontend**  | React.js, HTML, CSS                           |
| **Database**  | MySQL                                   	    |
| **APIs**      | RESTful APIs                                	|

## Setup and Installation

### Prerequisites

-   Java JDK 17 or later
-   Maven 3.2+
-   MySQL Server
-   Node.js and npm

### Backend Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git](https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git)
    ```
2.  **Configure the database:**
    -   Open `src/main/resources/application.properties`.
    -   Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties to match your local MySQL setup.
3.  **Run the application:**
    -   Navigate to the backend project's root directory.
    -   Run the command: `mvn spring-boot:run`
    -   The backend server will start on `http://localhost:8080`.

### Frontend Setup

1.  **Navigate to the frontend directory:**
    ```bash
    cd symptom-detection-frontend
    ```
2.  **Install dependencies:**
    ```bash
    npm install
    ```
3.  **Start the development server:**
    ```bash
    npm start
    ```
    -   The application will be available at `http://localhost:3000`.

### Video Tutorial
link - https://drive.google.com/file/d/1TqTFie1V5HRUskgrGDY5gMq6CKiOAMyz/view?usp=drive_link
