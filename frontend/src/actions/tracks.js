var mockApiData = [
    {
        id: 1,
        name: 'Enter Snadman'
    },
    {
        id: 2,
        name: 'Wehlcome Home'
    },
    {
        id: 3,
        name: 'Master of puppets'
    },
    {
        id: 4,
        name: 'Fade to Black'
    },
    {
        id: 5,
        name: 'Hell bells'
    }
];
export const getTracks = () => dispatch => {
    setTimeout(() => {
        console.log('I got tracks');
        dispatch({type: 'FETCH_TRACKS_SUCCESS', payload: mockApiData});
    }, 2000);
};