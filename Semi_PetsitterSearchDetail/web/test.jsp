function handlePaste (e) {
    var clipboardData, pastedData;
 
    // Stop data actually being pasted into div
    e.stopPropagation();
    e.preventDefault();
 
    // Get pasted data via clipboard API
    clipboardData = e.clipboardData || window.clipboardData;
    pastedData = clipboardData.getData('Text');
    
    // Do whatever with pasteddata
    alert(pastedData);
}
document.getElementById('testId').addEventListener('paste', handlePaste);