
export async function uploadProject(data) {
    return fetch('http://localhost:8080/api/projects/upload', {
      method: 'POST',
      body: data
    });
  }
  