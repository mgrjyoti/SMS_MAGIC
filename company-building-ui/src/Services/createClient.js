import axios from "axios";

const API_BASE_URL='http://localhost:8080/client';

export const createClient = async (clientData) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/clients`, clientData);
      return response.data;
    } catch (error) {
      console.error('Error creating client:', error);
      throw error;
    }
  };