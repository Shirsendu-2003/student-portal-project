function submitExam() {
    // Get user input
    const q1 = document.getElementById('q1').value.trim();
    const q2 = document.getElementById('q2').value.trim();
    
    // Define correct answers
    const correctAnswers = {
        q1: '4',
        q2: 'Paris'
    };

    // Check answers
    let score = 0;
    if (q1 === correctAnswers.q1) score++;
    if (q2.toLowerCase() === correctAnswers.q2.toLowerCase()) score++;
    
    // Display result
    const resultDiv = document.getElementById('result');
    resultDiv.textContent = `You scored ${score} out of ${Object.keys(correctAnswers).length}.`;
}